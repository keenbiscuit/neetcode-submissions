class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        // Append length & # to make it easier for decoding
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            String s = str.substring(j+1, i);
            result.add(s);
        }

        return result;
    }
}
