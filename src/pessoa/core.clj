(ns pessoa.core)

(defn set-entry!
  [url]
  "Commands will use this url as service entry point from now on")

(defn list-services
  [])

(defn list-api
  [service])

"
- help
  - types: depends
  - api: depends
  - dependencies
  - dist
  - status
    - check
  - restart
  - upload
  - about
    - name
    - version
    - hash

"

(defn edn-to-thrift [form])

(defn call
  [service f & args])

(defn debug
  [service f & args])
