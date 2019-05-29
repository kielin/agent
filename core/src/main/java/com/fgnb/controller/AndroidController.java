package com.fgnb.controller;

import com.fgnb.model.Response;
import com.fgnb.service.AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jiangyitao.
 */
@RestController
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private AndroidService androidService;

    /**
     * 开启adbkit
     *
     * @param deviceId
     * @return
     */
    @GetMapping("/adbkit/start/{deviceId}")
    public Response startAdbKit(@PathVariable String deviceId) {
        return androidService.startAdbKit(deviceId);
    }

    /**
     * 停止adbkit
     *
     * @param deviceId
     * @return
     */
    @GetMapping("/adbkit/stop/{deviceId}")
    public Response stop(@PathVariable String deviceId) {
        return androidService.stopAdbKit(deviceId);
    }

    /**
     * 开启Uiautomator2server
     *
     * @param deviceId
     * @return
     */
    @GetMapping("/uiautomator2server/start/{deviceId}")
    public Response start(@PathVariable String deviceId) {
        return androidService.startUiautomator2server(deviceId);
    }

    /**
     * dump当前布局
     * @param deviceId
     * @return
     */
    @GetMapping("/uiautomator2/dump/{deviceId}")
    public Response dump(@PathVariable String deviceId) {
        return androidService.dump(deviceId);
    }

    /**
     * 获取当前截图
     * @param deviceId
     * @return
     */
    @GetMapping("/screenshot/{deviceId}")
    public Response screenshot(@PathVariable String deviceId) {
        return androidService.screenshot(deviceId);
    }

    /**
     * 安装APK
     * @param apk
     * @param deviceId
     * @return
     */
    @PostMapping("/installApk/{deviceId}")
    public Response installApk(MultipartFile apk,@PathVariable String deviceId) {
        return androidService.installApk(apk,deviceId);
    }
}