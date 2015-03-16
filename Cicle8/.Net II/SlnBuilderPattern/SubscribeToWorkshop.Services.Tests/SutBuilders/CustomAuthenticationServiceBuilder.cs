using SubscribeToWorkshop.Domain;
using SubscribeToWorkshop.Domain.Interfaces;
using SubscribeToWorkshop.Domain.Models;
using SubscribeToWorkshop.Domain.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubscribeToWorkshop.Services.Tests.SutBuilders
{
    public class CustomAuthenticationServiceBuilder
    {
        private CloudService<User> _cloudService;

        public CustomAuthenticationServiceBuilder()
        {
            _cloudService = new AwsService<User>();
        }

        public CustomAuthenticationServiceBuilder WithAzureService(AzureService<User> azureService)
        {
            _cloudService = azureService;

            return this;
        }

        public CustomAuthenticationService Build()
        {
            return new CustomAuthenticationService(_cloudService);
        }

        public static implicit operator CustomAuthenticationService (CustomAuthenticationServiceBuilder builder)
        {
            return builder.Build();
        }
    }
}
