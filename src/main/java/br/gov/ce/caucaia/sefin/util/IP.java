/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

/**
 *
 * @author gilmario
 */
@Pattern.List(value = {
    @Pattern(regexp = "\\b(([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\b")})
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = {})
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IP {

    public String message() default "{br.gov.ce.caucaia.sefin.util.IP.message}";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
