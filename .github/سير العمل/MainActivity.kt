# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.
# This workflow will build a package using Gradle and then publish it to GitHub packages when a release is created
# For more information see: https://github.com/actions/setup-java/blob/main/docs/advanced-usage.md#Publishing-using-gradle

name: Gradle Package

on:
  release:
    types: [created]

jobs:
  build:

    runs-on: ubuntu-latest
    permissions:
      contents: read
      packages: write

    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
        server-id: github # Value of the distributionManagement/repository/id field of the pom.xml
        settings-path: ${{ github.workspace }} # location for the settings.xml file

    - name: Build with Gradle
      uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
      with:
        arguments: build

    # The USERNAME and TOKEN need to correspond to the credentials environment variables used in
    # the publishing section of your build.gradle
    - name: Publish to GitHub Packages
      uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
      with:
        arguments: publish
      env:
        USERNAME: ${{ github.actor }}
        TOKEN: ${{ secrets.GITHUB_TOKEN }}
