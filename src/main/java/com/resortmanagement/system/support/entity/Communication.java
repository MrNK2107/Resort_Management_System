/*
TODO: Communication.java
Purpose:
 - Store outbound messages (type, to, subject, snippet, status).
Fields:
 - id UUID
 - guestId UUID
 - type String (EMAIL,SMS)
 - to String (email/phone)
 - subject String
 - bodySnippet String
 - channel String (provider)
 - status String (SENT, FAILED)
 - sentAt Instant
 - extends Auditable
Notes:
 - For large email bodies, store in file store and only snippet in DB.
File: support/entity/Communication.java
*/
package com.resortmanagement.system.support.entity;

public class Communication {
    // TODO: fields, constructors, getters, setters
}