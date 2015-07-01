(set-env!
 :dependencies '[[adzerk/boot-template "1.0.0" :scope "test"]
                 [alandipert/boot-trinkets "1.0.1" :scope "test"]
                 [xalan "2.6.0" :scope "test"]
                 [org.jdom/jdom "1.1.3" :scope "test"]]
 :source-paths #{"test"}
 :resource-paths #{"src"})

(def +version+ "1.0.0-SNAPSHOT")

(require '[adzerk.boot-template :refer [template]]
         '[alandipert.boot-trinkets :refer [run]])

(deftask test
  "Build and test."
  []
  (comp
   (javac :options ["-Xlint:unchecked" "-Xlint:deprecation"])
   (run :main 'test.Test)))

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
