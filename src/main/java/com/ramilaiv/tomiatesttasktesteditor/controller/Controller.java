package com.ramilaiv.tomiatesttasktesteditor.controller;

import com.ramilaiv.tomiatesttasktesteditor.service.ServiceEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.AttributedString;

@RestController
@RequestMapping("/editor")
public class Controller {

    @Autowired
    ServiceEditor serviceEditor;

    @GetMapping("/add")
    public void add(@RequestParam String string) {
        serviceEditor.add(string);
    }

    @GetMapping("/add/position")
    public void addWithPosition(@RequestParam String string, @RequestParam int position) {
        serviceEditor.addWithPosition(string, position);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam int fromPosition, @RequestParam int toPosition) {
        serviceEditor.remove(fromPosition, toPosition);
    }

    @GetMapping("/italic")
    public void italic() {
        serviceEditor.italic();
    }

    @GetMapping("/bold")
    public void bold(int fromPosition, int toPosition) {
        serviceEditor.bold();
    }

    @GetMapping("/underline")
    public void underline(int fromPosition, int toPosition) {
        serviceEditor.underline();
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
    public void print() {
        serviceEditor.print();
    }
}
