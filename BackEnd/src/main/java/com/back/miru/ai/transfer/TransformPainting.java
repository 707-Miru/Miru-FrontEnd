package com.back.miru.ai.transfer;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TransformPainting {

    static Map<Integer, String> m = new HashMap<Integer, String>(){{
        put(1, "candy");
        put(2, "composition_vii");
        put(3, "escher_sphere");
        put(4, "feathers");
        put(5, "frida_kahlo");
        put(6, "la_muse");
        put(7, "mosaic");
        put(8, "mosaic_ducks_massimo");
        put(9, "pencil");
        put(10, "picasso");
        put(11, "portrait");
        put(12, "rain_princess");
        put(13, "seated_nude");
        put(14, "shipwreck");
        put(15, "starry_night");
        put(16, "stars");
        put(17, "strip");
        put(18, "the_scream");
        put(19, "udnie");
        put(20, "wave");
        put(21, "woman");
    }};

    public static void main(String[] args) throws Exception {
        System.out.println(transform("0",
                "src/main/java/com/back/miru/ai/transfer/s.jpg",
                "src/main/java/com/back/miru/ai/transfer/c.jpg",
                "rt"));
    }

    public static String transform(String optionNum, String styleFilePath, String contentFilePath, String id) throws Exception {
        int on = Integer.parseInt(optionNum);
        StringBuilder sb = new StringBuilder();

//        python main.py optim --content-image t.jpg --style-image m.jpeg --cuda=0
//        python main.py eval --content-image t.jpg --style-image m.jpeg --model models/21styles.model --content-size 1024 --cuda=0
        String root = "src/main/java/com/back/miru/ai/transfer/";
        String imgRoot = "/var/www/html/S07P12A707/BackEnd/src/main/resources/static/";
//        String imgRoot = "/var/www/html/S07P12A707/BackEnd/src/main/resources/static/21styles/filename.jpg";
//        String imgRoot = "src/main/java/com/back/miru/ai/transfer/";

        sb.append(imgRoot);
        sb.append("img/");
        sb.append(id);

        String makedimgPath = sb.toString();

        // 폴더 생성
        File convFile = new File(makedimgPath);
        System.out.println("convFile = " + convFile);
        if(!convFile.exists()) convFile.mkdir();

        String[] command = new String[20];
        command[0] = "python";
        command[1] = root + "main.py";
        command[2] = "eval";
        command[3] = "--content-image";
        command[4] = contentFilePath;
        command[5] = "--style-image";

        if (on == 0) {
            command[6] = styleFilePath;
        } else {
            command[6] = imgRoot + "21styles/" + m.get(on) + ".jpg";
        }

        command[7] = "--model";
        command[8] = root + "models/21styles.model";
        command[9] = "--content-size";
        command[10] = "1024";
        command[11] = "--output-image";
        command[12] = makedimgPath + "/output.jpg";
        command[13] = "--cuda=0";

        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        System.out.println(commandLine);
        int result = executor.execute(commandLine);
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream);

        return makedimgPath + "/output.jpg";
    }
}
