<%@ Page Title="" Language="C#" MasterPageFile="~/RafaelMiceliPrincipal.Master" AutoEventWireup="true" CodeBehind="RafaelMiceliLogin.aspx.cs" Inherits="RafaelMiceliAV1.RafaelMiceliLogin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:Label runat="server" ID="lblLogin" Text="Login"/>
    <asp:TextBox runat="server" ID="txtLogin" />
    <br />
    <asp:Label runat="server" ID="lblPassword" Text="Senha"/>
    <asp:TextBox runat="server" ID="txtPassword" TextMode="Password" />
    <br />
    <asp:Button runat="server" ID="btnLogin" Text="Login" OnClick="btnLogin_Click" />
</asp:Content>
