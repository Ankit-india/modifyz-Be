//package com.modifyz.PanelApplicaton.commons.utils;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//public class GenerateId {
//
////    public long generateUniqueId() {
////        // TODO generate unique Id
////        return 0l;
////    }
//
//    private static final String STATE_LETTERS = "AB"; // Replace with your desired state letters
//
//    public static String generateUniqueId() {
//        // Generate 2 state letters
//        String stateLetters = generateStateLetters();
//
//        // Generate 3-digit identification code
//        String identificationCode = generateIdentificationCode();
//
//        // Generate 4-digit date and month creation
//        String dateAndMonth = generateDateAndMonth();
//
//        // Generate last 4 random digits
//        String randomDigits = generateRandomDigits();
//
//        // Combine all parts to form the unique ID
//        return stateLetters + identificationCode + dateAndMonth + randomDigits;
//    }
//
//    private static String generateStateLetters() {
//        return StateName.UTTAR_PRADESH.getAbbreviation();
//    }
//
//    private static String generateIdentificationCode() {
//        Random random = new Random();
//        int identificationCode = random.nextInt(900) + 100; // Generates a 3-digit number between 100 and 999
//        return String.valueOf(identificationCode);
//    }
//
//    private static String generateDateAndMonth() {
//        DateFormat dateFormat = new SimpleDateFormat("MMdd");
//        Date currentDate = new Date();
//        return dateFormat.format(currentDate);
//    }
//
//    private static String generateRandomDigits() {
//        Random random = new Random();
//        int randomDigits = random.nextInt(9000) + 1000; // Generates a 4-digit number between 1000 and 9999
//        return String.valueOf(randomDigits);
//    }
//
//
//}
