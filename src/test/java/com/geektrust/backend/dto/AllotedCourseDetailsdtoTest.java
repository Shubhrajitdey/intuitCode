package com.geektrust.backend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Alloted CourseDetailsdto")
public class AllotedCourseDetailsdtoTest {
    @Test
    @DisplayName("should create a Alloted CourseDetailsdto")
    public void AllotedCourseDetailsdto() {
        AllotedCourseDetailsdto generatedBillDto = new AllotedCourseDetailsdto("REG-COURSE-ANDY-PYTHON","ANDY@GMAIL.COM","OFFERING-PYTHON-JOHN","PYTHON","JOHN","05062022","CONFIRMED");
        String expectedString="REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED";
        String acutalString=generatedBillDto.toString();
        assertEquals(expectedString,acutalString);
    }

}
