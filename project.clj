(defproject com.msgodf/cljondroid "0.0.1-SNAPSHOT"
  :description "Sample Android project to test lein-droid plugin."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :global-vars {*warn-on-reflection* true}

  :source-paths ["src/clojure" "src"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :plugins [[lein-droid "0.4.1"]]

  :dependencies [[org.clojure-android/clojure "1.7.0-r2"]
                 [neko/neko "3.2.0"]]
  :profiles {:default [:dev]

             :dev
             [:android-common :android-user
              {:dependencies [[org.clojure/tools.nrepl "0.2.10"]]
               :target-path "target/debug"
               :android {:aot :all-with-unused
                         :rename-manifest-package "com.msgodf.cljondroid.debug"
                         :manifest-options {:app-name "Android sample debug"}}}]
             :release
             [:android-common
              {:target-path "target/release"
               :android { 
                         :keystore-path "release-key.keystore"
                         :key-alias "release_key"

                         ;; :sigalg "MD5withRSA"

                         ;; You can specify these to avoid entering them for
                         ;; each rebuild, but generally it's a bad idea.
                         ;; :keypass "android"
                         ;; :storepass "android"

                         :ignore-log-priority [:debug :verbose]
                         :aot :all

                         :build-type :release}}]}

  :android {;; Specify the path to the Android SDK directory either here or in
            ;; :android-common profile in your ~/.lein/profiles.clj file.
            ;; :sdk-path "/home/user/path/to/android-sdk/"

            ;; Use this if you don't want to use the latest version of
            ;; Android Build Tools.
            ;; :build-tools-version "19.0.3"

            ;; Specify this if your project is a library.
            ;; :library true

            :dex-opts ["-JXmx4096M"]

            ;; Uncomment this if dexer fails with OutOfMemoryException.
            ;; :force-dex-optimize true

            ;; Uncomment this line to be able to use Google API.
            ;; :use-google-api true

            ;; This option allows you to specify Android support
            ;; libraries you want to use in your application.
            ;; Available versions: "v4", "v7-appcompat",
            ;; "v7-gridlayout", "v7-mediarouter", "v13".
            ;; :support-libraries ["v7-appcompat" "v13"]

            ;; Use this property to add project dependencies.
            ;; :project-dependencies [ "/path/to/library/project" ]

            ;; Sequence of external jars or class folders to include
            ;; into project.
            ;; :external-classes-paths ["path/to/external/jar/file"
            ;;                          "path/to/classfiles/"]

            ;; Sequence of jars, resources from which will be added to
            ;; application package.
            ;; :resource-jars-paths ["path/to/resource/jar"]

            ;; Sequence of native libraries files that will be added
            ;; to application package.
            ;; :native-libraries-paths ["path/to/native/library"]

            ;; Target version affects api used for compilation.
            :target-version 15

            ;; Sequence of namespaces that should not be compiled.
            :aot-exclude-ns ["clojure.parallel" "clojure.core.reducers"]

            ;; This specifies replacements which are inserted into
            ;; AndroidManifest-template.xml at build time. See Clostache for
            ;; more advanced substitution syntax. Version name and code are
            ;; automatically inserted
            :manifest-options {:app-name "@string/app_name"}
            })
