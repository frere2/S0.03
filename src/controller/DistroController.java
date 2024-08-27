package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {
	private String os() {
        return System.getProperty("os.name").toLowerCase();
    }

    public void exibeDistro() {
        String sistemaOperacional = os();

        if (sistemaOperacional.contains("linux")) {
            try {
                Process process = Runtime.getRuntime().exec("cat /etc/os-release");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("OS não é linux");
        }
    }
}
