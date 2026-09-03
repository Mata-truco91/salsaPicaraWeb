package com.salsapicara.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.salsapicara.demo.model.Pedido;
import com.salsapicara.demo.repository.PedidoRepository;
import com.salsapicara.demo.service.TelegramService;

@Controller
public class salsaPicaraController {
    TelegramService telegramService = new TelegramService();

    private final PedidoRepository pedidoRepository;

    public salsaPicaraController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

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
        @RequestParam("CodigoPostal") String codigoPostal,
     @RequestParam("cantidadPaquetes") int cantidadPaquetes,
        Model model) {

        int precio = 150;
       int precioPaquetes = 360;
       
       
       
        int totalIndividual = precio * cantidad;
int totalPaquete = precioPaquetes * cantidadPaquetes;
       double total = totalIndividual + totalPaquete;
       
        Pedido pedidos1 = new Pedido(nombre, telefono, cantidad, codigoPostal, total, cantidadPaquetes);
             

    String mensaje =
            "Nuevo pedido - Salsa Pícara\n\n" +
            "Cliente: " + pedidos1.getNombre() + "\n" +
            "Teléfono: " + pedidos1.getTelefono() + "\n" +
            "Cantidad: " + pedidos1.getCantidad() + "\n" +
"Cantidad de paquetes: " + pedidos1.getCantidadPaquetes() + "\n" +
            "Código Postal: " + pedidos1.getcodigoPostal() + "\n" +
            "Total: $" + pedidos1.getTotal() + " MXN";
         
            
 
            telegramService.enviarMensaje(mensaje);

    model.addAttribute("nombre", nombre);
    model.addAttribute("telefono", telefono);
    model.addAttribute("cantidad", cantidad);
    model.addAttribute("codigoPostal", codigoPostal);
    model.addAttribute("cantidadPaquetes", cantidadPaquetes);
    model.addAttribute("total", total);
    model.addAttribute("mensaje", mensaje);
           
    
    pedidoRepository.save(pedidos1);
    
    return "pedidos";
        }

    @GetMapping("/pedidos")
    public String pedidos(Model model) {
        return "pedidos";
    }

    @GetMapping("/comprar")
    public String comprar(Model model) {
        model.addAttribute("nombreSalsa", "Salsa Pícara");
        return "comprar";
    }

    @GetMapping("/redirectToWhatsapp")
public String redirectToWhatsapp(@RequestParam("telefono") String telefono, RedirectAttributes redirectAttributes) {
    String whatsappUrl = "https://wa.me/" + telefono;
    redirectAttributes.addFlashAttribute("whatsappUrl", whatsappUrl);
    return "redirect:" + whatsappUrl;


 }
}