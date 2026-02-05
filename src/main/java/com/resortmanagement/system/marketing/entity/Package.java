/*
TODO: Package.java
Purpose:
 - Promotional package definition.
Fields:
 - id UUID
 - name String
 - description String
 - price BigDecimal
 - componentsJson String (or use PackageItem rows)
 - validFrom, validTo
 - usageLimit int
 - extends Auditable
Notes:
 - Prefer explicit PackageItem rows rather than componentsJson for referential integrity.
File: marketing/entity/Package.java
*/
package com.resortmanagement.system.marketing.entity;

public class Package {
    // TODO: fields, constructors, getters, setters
}