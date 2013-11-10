package Presentation;

import Domain.Promotion;
import Domain.Supplier;
import Repository.PromotionRepository;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class PromotionService
{
    private PromotionRepository _promotionRepository;

    public PromotionService()
    {
        //Poor Mans Dependency Injection
        _promotionRepository = new PromotionRepository();
    }

    public void CreatePromotion()
    {
        boolean notFound = true;
        Promotion promotion = new Promotion();
        String selectedSupplierName = "";
        Supplier selectedSupplier = null;

        promotion.SetCode(JOptionPane.showInputDialog("Digite um Código"));
        promotion.SetTitle(JOptionPane.showInputDialog("Digite um Título"));

        System.out.println("Escolha um fornecedor pelo nome");

        SupplierService supplierService = new SupplierService();

        List<Supplier> suppliers = supplierService.GetSuppliers();

        for (Supplier supplier: suppliers)
            System.out.println(supplier.GetRazaoSocial());

        while(notFound)
        {
            selectedSupplierName = JOptionPane.showInputDialog("Nome do fornecedor");

            for (Supplier supplier: suppliers)
            {
                if(supplier.GetRazaoSocial().equalsIgnoreCase(selectedSupplierName))
                {
                    selectedSupplier = supplier;
                    notFound = false;
                    break;
                }
            }
        }

        promotion.SetSupplier(selectedSupplier);

        _promotionRepository.InsertPromotion(promotion);
    }

    public Promotion FindPromotionByCode(String code)
    {
        for (Promotion promotion: GetPromotions())
        {
            if (promotion.GetCode().equals(code))
                return promotion;
        }

        return null;
    }

    public List<Promotion> GetPromotions()
    {
        return _promotionRepository.GetPromotions();
    }
}
