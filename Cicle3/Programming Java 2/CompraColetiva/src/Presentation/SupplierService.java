package Presentation;

import Domain.Supplier;
import Repository.SupplierRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class SupplierService
{
    SupplierRepository _repository;

    public SupplierService()
    {
        //Poor Mans Dependency Injection
        _repository = new SupplierRepository();
    }

    public void CreateSupplier()
    {
        Supplier supplier = new Supplier();
        supplier.SetRazaoSocial(JOptionPane.showInputDialog("Digite a razao social"));
        supplier.SetCnpj(JOptionPane.showInputDialog("Digite o cnpj"));

        _repository.InsertSupplier(supplier);
    }

    public List<Supplier> GetSuppliers()
    {
        return _repository.GetSuppliers();
    }
}
