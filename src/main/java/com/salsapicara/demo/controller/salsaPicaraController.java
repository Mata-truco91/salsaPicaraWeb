package com.salsapicara.demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salsapicara.demo.model.Pedido;
import com.salsapicara.demo.repository.PedidoRepository;
import com.salsapicara.demo.service.TelegramService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

 @Controller
public class salsaPicaraController {
    TelegramService telegramService = new TelegramService();

@GetMapping("/")
public String inicio(Model model) {

    model.addAttribute("nombreSalsa", "Salsa Pícara");
    model.addAttribute("descripcion",
            "Una salsa casera con mucho sabor y un toque picante.");
    model.addAttribute("presentacion", "Botella de vidrio 250 ml");
    return "index";
}
@PostMapping("/pedidos")
public String pedido(
        @RequestParam("nombre") String nombre,
        @RequestParam("telefono") String telefono,
        @RequestParam("cantidad") int cantidad,
        Model model) {

            int precio = 150;
    int total = precio * cantidad;

   Pedido pedidos1 = new Pedido(
    nombre,
    telefono,
    cantidad,
    total
);
    String mensaje =
            "Nuevo pedido - Salsa Pícara\n\n" +
            "Cliente: " + pedidos1.getNombre() + "\n" +
            "Teléfono: " + pedidos1.getTelefono() + "\n" +
            "Cantidad: " + pedidos1.getCantidad() + "\n" +
            "Total: $" + pedidos1.getTotal() + " MXN";
         
            
 
            telegramService.enviarMensaje(mensaje);

    model.addAttribute("nombre", nombre);
    model.addAttribute("telefono", telefono);
    model.addAttribute("cantidad", cantidad);
    model.addAttribute("total", total);
    model.addAttribute("mensaje", mensaje);
           
    
    pedidoRepository.save(pedidos1);
    
    return "pedidos";
        }

 @GetMapping("/pedidos")
public String pedidos() {
    return "pedidos";
}


@GetMapping("/comprar")
public String comprar(Model model) {

    model.addAttribute("nombreSalsa", "Salsa Pícara");
  
    return "comprar";
}

private final PedidoRepository pedidoRepository;

public salsaPicaraController(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
}

}