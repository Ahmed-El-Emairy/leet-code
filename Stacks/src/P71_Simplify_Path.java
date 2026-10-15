import HelperFiles.StackObj;

public class P71_Simplify_Path {
    public static String simplifyPath(String path) {
        StackObj simplifiedPath = new StackObj(path.length());
        StringBuilder directoryName = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if (directoryName.length() == 0 && c == '/') {
                continue;
            } else if (c == '/') {
                String currentDir = directoryName.toString();

                if (!simplifiedPath.isEmpty() && currentDir.equals("..")) {
                    simplifiedPath.pop();
                } else if (currentDir.equals(".") || currentDir.equals("..")) {
                    directoryName.setLength(0);
                    continue;
                } else {
                    simplifiedPath.push(currentDir);
                }
                directoryName.setLength(0);

            } else {
                directoryName.append(c);
            }
        }

        if (directoryName.length() > 0) {
            String currentDir = directoryName.toString();
            if (!simplifiedPath.isEmpty() && currentDir.equals("..")) {
                simplifiedPath.pop();
            } else if (!(currentDir.equals(".") || currentDir.equals(".."))) {
                simplifiedPath.push(currentDir);
            }
        }

        // --- OPTIMIZED FINAL LOOP (Two-Stack Approach) ---

        // 1. Pop everything into a second stack to fix the LIFO order
        StackObj reverseStack = new StackObj(path.length());
        while (!simplifiedPath.isEmpty()) {
            reverseStack.push(simplifiedPath.pop());
        }

        // 2. Pop from the second stack and use fast O(1) appends
        StringBuilder finalPath = new StringBuilder();
        while (!reverseStack.isEmpty()) {
            finalPath.append("/").append(reverseStack.pop().toString());
        }

        return finalPath.length() == 0 ? "/" : finalPath.toString();
    }
}
