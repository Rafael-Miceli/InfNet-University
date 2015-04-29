using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ProjetoCafezinho.Startup))]
namespace ProjetoCafezinho
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
