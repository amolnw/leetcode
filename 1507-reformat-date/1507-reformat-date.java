import static java.util.Map.entry;  

class Solution {
    public String reformatDate(String date) {
        
        Map<String, String> months = Map.ofEntries(
                                            entry("Jan", "01"), 
                                            entry("Feb", "02"), 
                                            entry("Mar", "03"),
                                            entry("Apr", "04"), 
                                            entry("May", "05"), 
                                            entry("Jun", "06"),
                                            entry("Jul", "07"), 
                                            entry("Aug", "08"), 
                                            entry("Sep", "09"),
                                            entry("Oct", "10"), 
                                            entry("Nov", "11"), 
                                            entry("Dec", "12"));
        String[] tokens = date.split(" ");
        String day = tokens[0];
        String month = tokens[1];
        String year = tokens[2];
        
        if ( Character.isDigit(day.charAt(1)) ) {
            day = day.substring(0,2);
        }
        else {
            day = "0".concat(day.substring(0,1));
        }
        
        month = months.get(month);
        
        StringBuilder result = new StringBuilder();
        return result.append(year).append("-").append(month).append("-").append(day).toString();
    }
}