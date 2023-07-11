package com.ireport.mmodev.managed;

import com.ireport.mmodev.constants.Constants;
import com.ireport.mmodev.dao.ClienteDAO;
import com.ireport.mmodev.dao.MunicipioDAO;
import com.ireport.mmodev.dao.UFDao;
import com.ireport.mmodev.model.UF;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.jsf.FacesContextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public abstract class AbstractMB {
    public void gerarRelatorio(
            String nomeRelatorio,
            HashMap paramRel,
            List listaRel) throws Exception {

        FacesContext context = FacesContext.getCurrentInstance;
        HttpServletResponse response = (HttpServletResponse) context
                .getExternalContext()
                .getResponse();

        ServletContext sc = (ServletContext) context.getExternalContext().getContext();
        String relPath = sc.getRealPath("/");
        String imagemLogo = relPath + "resources/image/logo_mmo.jpg";

        paramRel.put("imagemLogo", imagemLogo);
        paramRel.put("nmSistema", Constants.NOME_SISTEMA);
        paramRel.put("REPORT_LOCALE", new Locale("pt", "BR"));
        JasperPrint print = null;
    }
}
