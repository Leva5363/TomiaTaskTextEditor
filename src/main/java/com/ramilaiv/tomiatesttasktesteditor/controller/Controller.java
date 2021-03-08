package com.ramilaiv.tomiatesttasktesteditor.controller;

import com.ramilaiv.tomiatesttasktesteditor.service.ServiceEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editor")
public class Controller {

    @Autowired
    ServiceEditor serviceEditor;

    @GetMapping("/add")
    public String add(@RequestParam String string) {
        return serviceEditor.add(string);
    }

    @GetMapping("/add/possition")
    public String addWithPosition(@RequestParam String string, @RequestParam int possition) {
        return serviceEditor.addWithPossition(string, possition);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam int fromPosition, @RequestParam int toPosition) {
        return serviceEditor.remove(fromPosition, toPosition);
    }

    @GetMapping("/italic")
    public String italic(int fromPosition, int toPosition) {
        return serviceEditor.italic(fromPosition, toPosition);
    }

    @GetMapping("/bold")
    public String bold(int fromPosition, int toPosition) {
        return serviceEditor.bold(fromPosition, toPosition);
    }

    @GetMapping("/underline")
    public String underline(int fromPosition, int toPosition) {
        return serviceEditor.underline(fromPosition, toPosition);
    }

    @GetMapping("/redo")
    public void redo() {
        serviceEditor.redo();
    }

    @GetMapping("/undo")
    public void undo() {
        serviceEditor.undo();
    }

    @GetMapping("/print")
    public String print() {
        return serviceEditor.print();
    }
}
