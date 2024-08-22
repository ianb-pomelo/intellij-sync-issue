load("@io_bazel_rules_kotlin//kotlin:core.bzl", "define_kt_toolchain")
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.7",
    experimental_report_unused_deps = "off",
    experimental_strict_kotlin_deps = "off",
    experimental_use_abi_jars = True,
    jvm_target = "11",
    language_version = "1.7",
)

kt_jvm_library(
    name = "test",
    srcs = ["TestFile.kt"],
    deps = [
        "@com_google_auto_factory",
        "@com_google_auto_factory//:compile",
    ],
)
