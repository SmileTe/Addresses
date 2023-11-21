package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

@JacksonXmlRootElement(localName = "ITEMS")
public class Hierarchy {

    @JacksonXmlProperty(isAttribute = true, localName = "ID")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "OBJECTID")
    private String objectId;

    @JacksonXmlProperty(isAttribute = true, localName = "PARENTOBJID")
    private String parentObjId;

    @JacksonXmlProperty(isAttribute = true, localName = "CHANGEID")
    private String changeId;

    @JacksonXmlProperty(isAttribute = true, localName = "PREVID")
    private String prevId;

    @JacksonXmlProperty(isAttribute = true, localName = "NEXTID")
    private String nextId;

    @JacksonXmlProperty(isAttribute = true, localName = "UPDATEDATE")
    private String updateDate;

    @JacksonXmlProperty(isAttribute = true, localName = "STARTDATE")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JacksonXmlProperty(isAttribute = true, localName = "ENDDATE")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @JacksonXmlProperty(isAttribute = true, localName = "ISACTIVE")
    @JsonSerialize(using=NumericBooleanSerializer.class)
    @JsonDeserialize(using=NumericBooleanDeserializer.class)

    private boolean isActive;

    public Hierarchy() {
    }

    public Hierarchy(String id, String objectId, String parentObjId, String changeId, String prevId, String nextId, String updateDate, LocalDate startDate, LocalDate endDate, boolean isActive) {
        this.id = id;
        this.objectId = objectId;
        this.parentObjId = parentObjId;
        this.changeId = changeId;
        this.prevId = prevId;
        this.nextId = nextId;
        this.updateDate = updateDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getParentObjId() {
        return parentObjId;
    }

    public void setParentObjId(String parentObjId) {
        this.parentObjId = parentObjId;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getPrevId() {
        return prevId;
    }

    public void setPrevId(String prevId) {
        this.prevId = prevId;
    }

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
