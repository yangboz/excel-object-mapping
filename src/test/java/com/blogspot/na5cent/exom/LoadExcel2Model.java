/*
 * code https://github.com/jittagornp/excel-object-mapping
 */
package com.blogspot.na5cent.exom;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author redcrow
 */
public class LoadExcel2Model
{

    // private static final Logger LOG = LoggerFactory.getLogger(LoadExcel2Model.class);
    private static Logger LOG = LogManager.getLogger(LoadExcel2Model.class);

    @Test
    public void test() throws Throwable
    {
        File excelFile = new File(getClass().getResource("/excel.xlsx").getPath());
        List<Model> items = ExOM.mapFromExcel(excelFile).toObjectOf(Model.class).map();

        for (Model item : items) {
            LOG.debug("first name --> {}", item.getFistName());
            LOG.debug("last name --> {}", item.getLastName());
            LOG.debug("age --> {}", item.getAge());
            LOG.debug("birth date --> {}", item.getBirthdate());
            LOG.debug("");
        }
    }
}
