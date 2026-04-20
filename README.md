### Hexlet tests and linter status:
[![Actions Status](https://github.com/astafeev-es/qa-auto-engineer-java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/astafeev-es/qa-auto-engineer-java-project-78/actions)
[![Build Status](https://github.com/astafeev-es/qa-auto-engineer-java-project-78/actions/workflows/build.yml/badge.svg)](https://github.com/astafeev-es/qa-auto-engineer-java-project-78/actions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=astafeev-es_qa-auto-engineer-java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=astafeev-es_qa-auto-engineer-java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=astafeev-es_qa-auto-engineer-java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=astafeev-es_qa-auto-engineer-java-project-78)

# Data Validator

## Description
This project is a universal data validator. It allows you to check if various data structures (Strings, Numbers, Maps) satisfy certain conditions. The validator supports method chaining for easy rule definition.

## Installation
To build the project, run:
```bash
make build
```

## Usage
```java
Validator v = new Validator();

StringSchema schema = v.string();
schema.isValid(""); // true
schema.required();
schema.isValid(""); // false
```

## Features
* String validation (required, minLength, contains)
* Number validation (required, positive, range)
* Map validation (required, sizeof, shape)