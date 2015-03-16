using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SubscribeToWorkshop.Domain.Models;
using SubscribeToWorkshop.Domain;
using SubscribeToWorkshop.Domain.Services;

namespace SubscribeToWorkshop.Services.Tests.SutBuilders
{
    public class WorkshopServiceBuilder
    {
        private CloudService<Workshop> _cloudService;

        public WorkshopServiceBuilder()
        {
            _cloudService = new AzureService<Workshop>();
        }

        public WorkshopServiceBuilder WithAzureServiceInstance(AzureService<Workshop> azureService)
        {
            _cloudService = azureService;
            return this;
        }

        public WorkshopServiceBuilder WithAmazonServiceInstance(AwsService<Workshop> awsService)
        {
            _cloudService = awsService;
            return this;
        }

        public WorkshopServices Build()
        {
            return new WorkshopServices(_cloudService);
        }

    }
}
