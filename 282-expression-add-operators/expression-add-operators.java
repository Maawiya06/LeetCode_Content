class Solution {

    private void solve(String num,
                       int target,
                       int i,
                       long valueOfExpression,
                       long lastNumber,
                       String expression,
                       List<String> result) {

        if (i == num.length()) {
            if (valueOfExpression == target) {
                result.add(expression);
            }
            return;
        }

        for (int start = i; start < num.length(); start++) {
            if (start > i && num.charAt(i) == '0') break;

            String part = num.substring(i, start + 1);
            long curr = Long.parseLong(part);

            if (i == 0) {
                solve(num, target, start + 1, curr, curr, part, result);
            } 
            else {
                solve(num, target, start + 1, valueOfExpression + curr, curr, 
                            expression + "+" + part, result);

                solve(num, target, start + 1, valueOfExpression - curr, -curr,
                            expression + "-" + part, result);

                solve(num, target, start + 1, valueOfExpression - lastNumber + lastNumber * curr,
                            lastNumber * curr, expression + "*" + part, result);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        solve(num, target, 0, 0, 0, "", result);
        return result;
    }
}
