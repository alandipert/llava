(set-env! :source-paths #{"org"})

(deftask build
  "Build the Llava distribution."
  []
  (javac :options ["-Xlint:unchecked"])
  )
