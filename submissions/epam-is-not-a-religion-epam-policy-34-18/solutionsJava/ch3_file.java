public static void f() {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(new File("\\solutionsJava\\text.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
        System.out.println(line);
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        }