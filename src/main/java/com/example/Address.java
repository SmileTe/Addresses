package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
@JacksonXmlRootElement(localName = "ADDRESSOBJECTS")
public class Address {
    @JacksonXmlProperty(isAttribute = true, localName = "ID")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "OBJECTID")
    private String objectId;

    @JacksonXmlProperty(isAttribute = true, localName = "OBJECTGUID")
    private String objectGuid;

    @JacksonXmlProperty(isAttribute = true, localName = "CHANGEID")
    private String changeId;

    @JacksonXmlProperty(isAttribute = true, localName = "NAME")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "TYPENAME")
    private String typeName;

    @JacksonXmlProperty(isAttribute = true, localName = "LEVEL")
    private String level;

    @JacksonXmlProperty(isAttribute = true, localName = "OPERTYPEID")
    private String operTypeId;

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

    @JacksonXmlProperty(isAttribute = true, localName = "ISACTUAL")
    @JsonSerialize(using=NumericBooleanSerializer.class)
    @JsonDeserialize(using=NumericBooleanDeserializer.class)

    private boolean isActual;

    @JacksonXmlProperty(isAttribute = true, localName = "ISACTIVE")
    @JsonSerialize(using=NumericBooleanSerializer.class)
    @JsonDeserialize(using=NumericBooleanDeserializer.class)

    private boolean isActive;




    public Address() {
    }

    public Address(String id, String objectId, String objectGuid, String changeId, String name, String typeName, String level, String operTypeId, String prevId, String nextId, String updateDate, LocalDate startDate, LocalDate endDate, boolean isActual, boolean isActive) {
        this.id = id;
        this.objectId = objectId;
        this.objectGuid = objectGuid;
        this.changeId = changeId;
        this.name = name;
        this.typeName = typeName;
        this.level = level;
        this.operTypeId = operTypeId;
        this.prevId = prevId;
        this.nextId = nextId;
        this.updateDate = updateDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActual = isActual;
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

    public String getObjectGuid() {
        return objectGuid;
    }

    public void setObjectGuid(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOperTypeId() {
        return operTypeId;
    }

    public void setOperTypeId(String operTypeId) {
        this.operTypeId = operTypeId;
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

    public boolean getIsActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }




}


