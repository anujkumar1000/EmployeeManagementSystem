/*
 * This file is generated by jOOQ.
 */
package com.leadsquared.employeemanagement.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public enum PhonePhoneType implements EnumType {

    Mobile_Phone("Mobile_Phone"),

    Landline("Landline"),

    Feature_Phone("Feature_Phone"),

    Virtual_Phone("Virtual_Phone"),

    Satellite_Phone("Satellite_Phone");

    private final String literal;

    private PhonePhoneType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static PhonePhoneType lookupLiteral(String literal) {
        return EnumType.lookupLiteral(PhonePhoneType.class, literal);
    }
}
