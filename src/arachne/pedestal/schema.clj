(ns arachne.pedestal.schema
  (:require [arachne.core.config :refer [tempid]]
            [arachne.core.config.model :as o]))

(def schema

  (concat

    (o/type :arachne.pedestal/Server [:arachne.http/Server]
      "A Pedestal HTTP server")

    (o/type :arachne.pedestal/Endpoint [:arachne.http/Endpoint]
      "A Pedestal Endpoint"
      :arachne.pedestal.specs/endpoint)

    (o/type :arachne.pedestal/Interceptor []
      "A Pedestal interceptor as part of an Arachne HTTP routing structure."
      (o/attr :arachne.pedestal.interceptor/component :one :arachne/Component
        "The component satisfying Pedestal's IntoInterceptor protocol.")
      (o/attr :arachne.pedestal.interceptor/route :one :arachne.http/RouteSegment
        "The node in the routing tree to which attach the interceptor. The interceptor will be applied to all requests for this node and its descendants.")
      (o/attr :arachne.pedestal.interceptor/priority :one-or-none :long
        "The priority of the interceptor relative to other interceptors on the same route segment. Higher priority interceptors will be placed earlier on the interceptor chain. If priority is equal, ordering will be arbitrary.")))

  )
