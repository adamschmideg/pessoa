(ns pessoa.core)

(defn set-entry!
  [url]
  "Commands will use this url as service entry point from now on")

(defn list-services
  [])

(defn list-api
  [service])

"
- about
  - types: depends
  - api: depends
  - thrift
  - dependencies
  - dist
  - status
    - check
  - version
    - name
    - hash
- system
  - restart
  - upload

"

(defmacro with-mock
  [service end-point f])

(defn edn-to-thrift [form])

(defn call
  [service f & args])

(defn debug
  [service f & args])
