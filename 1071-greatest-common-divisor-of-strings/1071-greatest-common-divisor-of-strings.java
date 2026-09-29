class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if (str1.equals(str2)) {
            return str1;
        }

        if (str1.length() > str2.length()) {

            if (!str1.startsWith(str2)) {
                return "";
            }

            return gcdOfStrings(
                str1.substring(str2.length()),
                str2
            );

        } else {

            if (!str2.startsWith(str1)) {
                return "";
            }

            return gcdOfStrings(
                str1,
                str2.substring(str1.length())
            );
        }
    }
}