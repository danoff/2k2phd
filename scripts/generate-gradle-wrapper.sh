#!/usr/bin/env bash
set -euo pipefail

readonly GRADLE_VERSION="8.6"
readonly DISTRIBUTION_SHA256="9631d53cf3e74bfa726893aee1f8994fee4e876e8e64da9e3044b3d6d8e272d5"
readonly REPOSITORY_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
readonly MOBILE_APP_DIR="${REPOSITORY_ROOT}/mobile-app"
readonly TEMP_DIR="$(mktemp -d)"
trap 'rm -rf "${TEMP_DIR}"' EXIT

if ! command -v gradle >/dev/null 2>&1; then
  echo "Gradle must be installed to generate the wrapper." >&2
  exit 1
fi

printf 'rootProject.name = "wrapper-bootstrap"\n' > "${TEMP_DIR}/settings.gradle"
printf '' > "${TEMP_DIR}/build.gradle"

gradle --project-dir "${TEMP_DIR}" wrapper \
  --gradle-version "${GRADLE_VERSION}" \
  --distribution-type bin \
  --gradle-distribution-sha256-sum "${DISTRIBUTION_SHA256}" \
  --no-validate-url

# Generation can run behind a restricted proxy, but wrapper use must validate
# the configured distribution URL before downloading it.
sed -i 's/^validateDistributionUrl=false$/validateDistributionUrl=true/' \
  "${TEMP_DIR}/gradle/wrapper/gradle-wrapper.properties"

mkdir -p "${MOBILE_APP_DIR}/gradle/wrapper"
cp "${TEMP_DIR}/gradlew" "${TEMP_DIR}/gradlew.bat" "${MOBILE_APP_DIR}/"
cp "${TEMP_DIR}/gradle/wrapper/gradle-wrapper.jar" \
  "${TEMP_DIR}/gradle/wrapper/gradle-wrapper.properties" \
  "${MOBILE_APP_DIR}/gradle/wrapper/"

echo "Generated the Gradle ${GRADLE_VERSION} wrapper in mobile-app/."
echo "Commit all four generated wrapper files with ordinary binary-capable Git."
