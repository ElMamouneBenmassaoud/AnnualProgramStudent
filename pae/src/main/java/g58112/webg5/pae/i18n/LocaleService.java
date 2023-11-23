package g58112.webg5.pae.i18n;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@ControllerAdvice
public class LocaleService {
    @ModelAttribute
    public LocaleService localeService() {
        return new LocaleService();
    }

    public String changeTo(String lang) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replaceQueryParam("lang", lang)
                .toUriString();
    }
}

