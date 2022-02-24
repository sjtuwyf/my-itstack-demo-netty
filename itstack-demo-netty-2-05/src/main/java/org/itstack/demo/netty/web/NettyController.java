package org.itstack.demo.netty.web;

import org.itstack.demo.netty.server.NettyServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
@Controller
public class NettyController {

    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name","xiaohao");
        return "index";
    }

}
