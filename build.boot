(set-env!
 :dependencies '[[adzerk/boot-template "1.0.0"]]
 :resource-paths #{"src"})

(def +version+ "1.0.0-SNAPSHOT")

(require '[adzerk.boot-template :refer [template]])

(deftask build
  "Build the Llava distribution."
  []
  (comp
   (template :paths ["org/llava/impl/LlavaVersionImpl.java"]
             :subs {"VERSION" +version+})
   (javac :options ["-Xlint:unchecked"])
   (pom :project 'alandipert/llava
        :version +version+
        :description "Java in Lisp syntax")
   (jar :main 'org.llava.Llava)))
