using System;
using SubscribeToWorkshop.Domain.Interfaces;
using SubscribeToWorkshop.Domain.Models;
using SubscribeToWorkshop.Domain.Services;
using NUnit.Framework;
using SubscribeToWorkshop.Services.Tests.SutBuilders;

namespace SubscribeToWorkshop.Services.Tests.Services
{
    [TestFixture]
    public class TestAuthenticationService
    {
        [Test]
        public void Given_a_User_With_Permission_When_Verifying_If_Authorized_Then_Authorize_It_Returning_True()
        {
            CustomAuthenticationService sut = new CustomAuthenticationServiceBuilder();
            User userWithAuthorization = null;
            
            var result = sut.IsAuthorized(userWithAuthorization);

            Assert.That(result, Is.True);
        }
    }
}
