package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


public class StateCensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Shuchita Singh\\src\\test\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\Shuchita Singh\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_TYPE = "C:\\Users\\Shuchita Singh\\src\\test\\resources\\IndiaStateCensusData.txt";
    private static final String CSV_FILE_WITH_WRONG_DELIMITER = "C:\\Users\\Shuchita Singh\\src\\main\\resources\\IndiaStateCensusData - Copy.csv";

    private Assertions Assert;

    /**
     * this test case checking given csv file should have correct records or not in it..
     */
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    /**
     * test case is use to when given wrong csv file return custom exception...

     1.2*/
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * file is correct but type is incorrect then thrown exception
     1.3 */
    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    /**
     * given indian census file is correct but delimeter wrong should return custom exception....
     * @throws CensusAnalyserException
     */
    @Test
    public void givenIndianCensusCSVFile_WhenCorrectButDelimiterWrong_ShouldThrowException() throws CensusAnalyserException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CSV_FILE_WITH_WRONG_DELIMITER);
        } catch (CensusAnalyserException x) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, x.type);
        }
    }

    /**
     * when csv file is correct but csv header is incorrect return throw exception
     * @throws CensusAnalyserException
     */
    @Test
    public void givenIndianCensusCSVFile_WhenCorrectButCSVHeaderIncorrect_ShouldThrowException() throws CensusAnalyserException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CSV_FILE_WITH_WRONG_DELIMITER);
        } catch (CensusAnalyserException x) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, x.type);
        }
    }
}
