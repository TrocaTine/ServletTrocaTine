function dashSelection(optionSelect, selectTag) {
    const savedOption = localStorage.getItem("selectedDashboard");
    if (savedOption) {
        optionSelect.value = savedOption;
        if (savedOption == 2) {
            optionTag.options[1].selected = true;
        }
    } else {
        optionSelect.value = 1;
    }
    optionSelect.addEventListener("change", (e) => {
        const selectedValue = e.target.value;
        localStorage.setItem("selectedDashboard", selectedValue);
        iframeUrl(selectedValue);
    });
    iframeUrl(optionSelect.value);
}

function iframeUrl(value) {
    const iframe = document.getElementById("iframe").querySelector("iframe");

    if (iframe) {
        let src =
            "https://app.powerbi.com/view?r=eyJrIjoiNGIwNWZlYTktMDRmZS00NmRiLWEwNjMtNjIyMDgwYjUwMjZjIiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9&pageName=4e0b150f845d8b87c2eb";
        if (value == "2") {
            src =
                "https://app.powerbi.com/view?r=eyJrIjoiNzZiOWU2MDItZDM1Yy00Y2FlLTlkYTMtNTZiMjgzNzE5MmU5IiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9";
        }

        iframe.src = src;
    }
}

function windowSize() {
    const windowWidth = window.innerWidth;
    const optionSelect = document.getElementById("option");
    const divIframe = document.getElementById("iframe");

    let iframeElement = divIframe.querySelector("iframe");
    if (!iframeElement) {
        iframeElement = document.createElement("iframe");
        iframeElement.frameBorder = "0";
        iframeElement.allowFullscreen = true;
        iframeElement.width = "1200";
        iframeElement.height = "700";
        divIframe.append(iframeElement);
    }

    if (windowWidth > 500) {
        optionSelect.classList.add("a");
        iframeElement.width = "1200";
        iframeElement.height = "700";
        iframeElement.src =
            "https://app.powerbi.com/view?r=eyJrIjoiNGIwNWZlYTktMDRmZS00NmRiLWEwNjMtNjIyMDgwYjUwMjZjIiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9&pageName=a433bc7b9e17650b89ba";
    } else {
        optionSelect.classList.remove("a");
        iframeElement.width = "600";
        iframeElement.height = "400";
        iframeUrl(optionSelect.value);
    }
}

const optionSelect = document.getElementById("option");
const selectTag = document.getElementById("select");
dashSelection(optionSelect, selectTag);
windowSize();
window.addEventListener("resize", windowSize);