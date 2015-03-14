<%@ Page Title="" Language="C#" MasterPageFile="~/RafaelMiceliPrincipal.Master" AutoEventWireup="true" CodeBehind="RafaelMiceliCafe.aspx.cs" Inherits="RafaelMiceliAV1.RafaelMiceliCafe" %>
<%@ Register Src="~/RafaelMiceliuccafe.ascx" TagPrefix="uc1" TagName="RafaelMiceliuccafe" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <uc1:RafaelMiceliuccafe runat="server" ID="RafaelMiceliuccafe" />
    <br />
    <asp:TextBox runat="server" ID="txtCoffeType" />
    <br />
    <asp:Button runat="server" ID="btnRegisterCoffe" Text="Registrar Café" OnClick="btnRegisterCoffe_Click" />
</asp:Content>
