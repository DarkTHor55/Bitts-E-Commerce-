import AliceCarousel from "react-alice-carousel";
import HomeSectinCard from "../HomeSectionCards/HomeSectinCard";

const HomeSectionCarousel = ({ data,sectionName }) => {
  const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 5.5 },
  };

  const items = data
    .slice(0, 10)
    .map((product, index) => <HomeSectinCard key={index} product={product} />);

  return (
    <div className="relative px-4 lg:px-8">
        <div className="text-3xl font-extrabold text-gray-800 py-5">
            <h2>{sectionName}</h2>
        </div>
      <div
        className="relative px-5 border border-solid"
        style={{ borderColor: "#657786" }}
      >
        <AliceCarousel
          items={items}
          disableButtonsControls
          responsive={responsive}
          autoPlay
          autoPlayInterval={2000}
          infinite
        />
      </div>
    </div>
  );
};

export default HomeSectionCarousel;
