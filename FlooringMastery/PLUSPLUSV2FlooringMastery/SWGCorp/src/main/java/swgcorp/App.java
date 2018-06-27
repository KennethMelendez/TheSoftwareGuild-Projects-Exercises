/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import swgcorp.controller.Controller;

import swgcorp.dao.Dao;
import swgcorp.dao.DaoImpl;
import swgcorp.dao.PersistenceException;
import swgcorp.dao.TrainingModeDaoImpl;
import swgcorp.dto.CalculateOutputs;
import swgcorp.dto.ConfigSettings;
import swgcorp.dto.StateTaxRates;
import swgcorp.servicelayer.ServiceLayer;
import swgcorp.servicelayer.ServiceLayerImpl;
import swgcorp.ui.UserIO;
import swgcorp.ui.UserIOImpl;
import swgcorp.ui.View;

/**
 *
 * @author kmlnd
 */
public class App {

    public static void main(String[] args) throws PersistenceException {

        //---------------------------------------------------------------------------------------------------------------
        /*============================================================================
        Getting the Apllication context xml and assigning it to a variable
        ============================================================================*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigSettings config = ctx.getBean("ConfigSettings", ConfigSettings.class);

        /*============================================================================
        Declaring/Assigning both controllers || Production mode | Training mode    
        ============================================================================*/
        //Controller controller = ctx.getBean("Controller", Controller.class);
        //use get bean instead
        //TrainingModeController TrainingModeController = ctx.getBean("TrainingModeController", TrainingModeController.class);

        /*============================================================================
        If Training mode is read from file run the given controller    
        ============================================================================*/
        String MODE = "";
        if (config.isTrainingModeActive() == true) {
            MODE = "TrainingController";

        } else {

            MODE = "Controller";
        }

        Controller controller = ctx.getBean(MODE, Controller.class);
        controller.run();

        //---------------------------------------------------------------------------------------------------------------
    }
}

