package com.github.superjoy0502.HomeworkMachine;

import com.asprise.imaging.core.Imaging;
import com.asprise.imaging.core.Request;
import com.asprise.imaging.core.Result;
import com.asprise.imaging.scan.ui.workbench.AspriseScanUI;

import java.io.IOException;

public class Scan {
    public static void main(String[] args) {
        return;
    }

    public void scanWithDialog() throws IOException {
        Result result = new AspriseScanUI().setRequest(Request.fromJson(
                "{"
                        + "\"output_settings\" : [ {"
                        + "  \"type\" : \"save\","
                        + "  \"format\" : \"pdf\","
                        + "  \"save_path\" : \"${TMP}\\\\${TMS}${EXT}\""
                        + "} ]"
                        + "}"))
                .setInstruction("Scan <b>test</b>")
                .showDialog(null, "Dialog Title", true, null);

        System.out.println(result == null ? "(null)" : result.toJson(true));
        Application.openPDF(result.getPdfFile().getAbsolutePath());
    }

    public void scanWithoutDialog() throws IOException{
        Imaging imaging = new Imaging("myApp", 0);
        Result result = imaging.scan(Request.fromJson(
                "{"
                        + "\"output_settings\" : [ {"
                        + "  \"type\" : \"save\","
                        + "  \"format\" : \"pdf\","
                        + "  \"save_path\" : \"${TMP}\\\\${TMS}${EXT}\""
                        + "} ]"
                        + "}"), "select", false, false);

        System.out.println(result == null ? "(null)" : result.toJson(true));
        Application.openPDF(result.getPdfFile().getAbsolutePath());
    }
}
