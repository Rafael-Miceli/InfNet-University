using System;
using NUnit.Framework;
using SubscribeToWorkshop.Domain;
using SubscribeToWorkshop.Services.Tests.SutBuilders;

namespace SubscribeToWorkshop.Services.Tests
{
    [TestFixture]
    public class TestWorshopServices
    {
        [Test]
        public void When_Creating_A_Valid_Workshop_Should_Return_True()
        {
            string workshopName = null;
            string workshopDate = null;
            WorkshopServices sut = new WorkshopServiceBuilder().Build();            

            var result = sut.CreateWorkshop(workshopName, workshopDate);

            Assert.That(result, Is.True);
        }

        [Test]
        public void When_Listing_Workshops_Should_Return_True_A_List_Of_Workshops()
        {
            string workshopName = null;
            string workshopDate = null;
            WorkshopServices sut = new WorkshopServiceBuilder().Build();

            var result = sut.ListWorkshops();

            Assert.That(result.Count, Is.GreaterThan(0));
        }
    }
}
