package jfSpringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palindormos
 */
@RestController
public class PalindromeController {
    /**
     * Endpoint para verficar si la palabra es un palindromo
     * @param word la palabra a verficar
     * @return mensaje indicado si la palabra es un palindromo o no
     */
    @GetMapping("/check-palindrome/{word}")

    public String Palindrome(@PathVariable String word)
    {
        if(isPalindrome(word)){
            return "la palabra "+word+ " es un palindromo";
        } else {
            return "La palabra "+word+ " no es un palindromo";
        }
    }

    /**
     * funcion para validar si la palabra es un palindromo
     * @param word la palabra a validar
     * @return true si es un palindromo
     */

    private boolean isPalindrome(String word){
        int length = word.length();

        for (int i = 0; i< (length/2); i++){
            if(word.charAt(i) != word.charAt(length - i -1)){
                return false;
            }
        }
        return true;
    }
}
