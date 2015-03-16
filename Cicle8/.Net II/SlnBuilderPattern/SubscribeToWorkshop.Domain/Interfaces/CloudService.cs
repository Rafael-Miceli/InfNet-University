using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubscribeToWorkshop.Domain
{
    public interface CloudService<T>
    {
        void Add(T entity);
    }
}
