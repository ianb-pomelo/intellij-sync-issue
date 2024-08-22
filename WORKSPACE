load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_file")

http_archive(
    name = "rules_jvm_external",
    sha256 = "c4cd0fd413b43785494b986fdfeec5bb47eddca196af5a2a98061faab83ed7b2",
    strip_prefix = "rules_jvm_external-5.1",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/refs/tags/5.1.zip",
)

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "5766f1e599acf551aa56f49dab9ab9108269b03c557496c54acaf41f98e2b8d6",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v1.9.0/rules_kotlin-v1.9.0.tar.gz",
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

kotlin_repositories()

register_toolchains("//:kotlin_toolchain")

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.guava:guava:32.1.1-jre",
        "com.squareup:javapoet:1.13.0",
        "com.google.auto:auto-common:1.2.2",
    ],
    duplicate_version_warning = "error",
    fail_on_missing_checksum = True,
    generate_compat_repositories = True,
    repositories = [
        "https://repo.maven.apache.org/maven2/",
    ],
)

load("@bazel_tools//tools/build_defs/repo:java.bzl", "java_import_external")

java_import_external(
    name = "com_google_auto_factory",
    extra_build_file_content = "\n".join([
        "java_plugin(",
        "    name = \"AutoFactoryProcessor\",",
        "    generates_api = True,",
        "    processor_class = \"com.google.auto.factory.processor.AutoFactoryProcessor\",",
        "    deps = [\":processor\"],",
        ")",
        "",
        "java_library(",
        "    name = \"com_google_auto_factory\",",
        "    exported_plugins = [\":AutoFactoryProcessor\"],",
        "    exports = [\":compile\"],",
        ")",
    ]),
    generated_linkable_rule_name = "processor",
    generated_rule_name = "compile",
    jar_sha256 = "d59fb7ada5962a480abf0b81d4d2a14a2952f17c026732359af8b585e531c16c",
    jar_urls = [
        "https://domain-registry-maven.storage.googleapis.com/repo1.maven.org/maven2/com/google/auto/factory/auto-factory/1.0.1/auto-factory-1.0.1.jar",
        "https://repo1.maven.org/maven2/com/google/auto/factory/auto-factory/1.0.1/auto-factory-1.0.1.jar",
    ],
    licenses = ["notice"],  # Apache 2.0
    neverlink = True,
    deps = [
        "@maven//:com_google_auto_auto_common",
        "@maven//:com_google_guava_guava",
        "@maven//:com_squareup_javapoet",
    ],
)
